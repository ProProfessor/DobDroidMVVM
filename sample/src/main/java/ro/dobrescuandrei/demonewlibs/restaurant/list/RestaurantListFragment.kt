package ro.dobrescuandrei.demonewlibs.restaurant.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.Subscribe
import ro.andreidobrescu.declarativeadapterkt.SimpleDeclarativeAdapter
import ro.dobrescuandrei.demonewlibs.R
import ro.dobrescuandrei.demonewlibs.model.Restaurant
import ro.dobrescuandrei.demonewlibs.model.RestaurantFilter
import ro.dobrescuandrei.demonewlibs.model.utils.RefreshRestaurantListCommand
import ro.dobrescuandrei.demonewlibs.restaurant.list.cells.RestaurantCellView
import ro.dobrescuandrei.demonewlibs.router.ActivityRouter
import ro.dobrescuandrei.demonewlibs.router.ShowDialog
import ro.dobrescuandrei.mvvm.list.BaseListFragment
import ro.dobrescuandrei.utils.set
import ro.dobrescuandrei.utils.setMenu
import ro.dobrescuandrei.utils.setupBackIcon

class RestaurantListFragment : BaseListFragment<RestaurantListViewModel, SimpleDeclarativeAdapter<Restaurant>, RestaurantFilter>()
{
    override fun provideAdapter() = SimpleDeclarativeAdapter { RestaurantCellView(it) }
    override fun provideEmptyViewText() = getString(R.string.no_restaurants)
    override fun viewModelClass() = RestaurantListViewModel::class.java
    override fun layout() = R.layout.fragment_restaurant_list

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view=super.onCreateView(inflater, container, savedInstanceState)

        toolbar.setupBackIcon()
        toolbar.setMenu(R.menu.menu_restaurants)
        toolbar[R.id.filterByRating]={
            ShowDialog.withList(context = context!!,
                title = R.string.choose_rating,
                onClick = { index, value ->
                    viewModel.notifyFilterChange { filter ->
                        filter.rating=value
                    }
                },
                values = listOf(1,2,3,4,5))
        }

        toolbar[R.id.filterByType]={
            ShowDialog.withList(context = context!!,
                title = R.string.choose_type,
                onClick = { index, value ->
                    viewModel.notifyFilterChange { filter ->
                        filter.type=index+1
                    }
                },
                values = listOf(
                    getString(R.string.normal),
                    getString(R.string.fast_food)))
        }

        return view
    }

    override fun onAddButtonClicked()
    {
        ActivityRouter.startAddRestaurantActivity(from = context!!)
    }

    @Subscribe
    fun refresh(command : RefreshRestaurantListCommand)
    {
        viewModel.loadData()
    }
}
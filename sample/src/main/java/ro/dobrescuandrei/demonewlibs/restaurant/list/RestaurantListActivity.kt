package ro.dobrescuandrei.demonewlibs.restaurant.list

import ro.dobrescuandrei.demonewlibs.model.Restaurant
import ro.dobrescuandrei.demonewlibs.model.utils.OnRestaurantChoosedEvent
import ro.dobrescuandrei.mvvm.chooser.BaseFragmentContainerActivity
import ro.dobrescuandrei.mvvm.eventbus.BackgroundEventBus

class RestaurantListActivity : BaseFragmentContainerActivity<RestaurantListFragment, Restaurant>()
{
    override fun provideFragment() = RestaurantListFragment()

    override fun onBackPressed()
    {
        if (fragment.shouldFinishActivityOnBackPressed())
            super.onBackPressed()
    }

    override fun onItemChoosed(restaurant : Restaurant)
    {
        BackgroundEventBus.post(OnRestaurantChoosedEvent(restaurant))
        finish()
    }
}
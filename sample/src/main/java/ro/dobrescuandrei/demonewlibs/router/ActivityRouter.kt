package ro.dobrescuandrei.demonewlibs.router

import android.content.Context
import android.content.Intent
import ro.dobrescuandrei.demonewlibs.model.Restaurant
import ro.dobrescuandrei.demonewlibs.restaurant.details.RestaurantDetailsActivity
import ro.dobrescuandrei.demonewlibs.restaurant.editor.RestaurantEditorActivity
import ro.dobrescuandrei.demonewlibs.restaurant.list.RestaurantListActivity
import ro.dobrescuandrei.demonewlibs.restaurant.list.RestaurantPagedListActivity
import ro.dobrescuandrei.demonewlibs.user.login.LoginActivity
import ro.dobrescuandrei.mvvm.navigation.setChooseMode
import ro.dobrescuandrei.mvvm.navigation.setModel

object ActivityRouter
{
    fun startLoginActivity(from : Context)
    {
        val i=Intent(from, LoginActivity::class.java)
        from.startActivity(i)
    }

    fun startRestaurantListActivity(from : Context)
    {
        val i=Intent(from, RestaurantListActivity::class.java)
        from.startActivity(i)
    }

    fun startChooseRestaurantActivity(from : Context)
    {
        val i=Intent(from, RestaurantListActivity::class.java)
        i.setChooseMode()
        from.startActivity(i)
    }

    fun startChoosePagedRestaurantActivity(from : Context)
    {
        val i=Intent(from, RestaurantPagedListActivity::class.java)
        i.setChooseMode()
        from.startActivity(i)
    }

    fun startAddRestaurantActivity(from : Context)
    {
        val i=Intent(from, RestaurantEditorActivity::class.java)
        from.startActivity(i)
    }

    fun startEditRestaurantActivity(from : Context, restaurant : Restaurant)
    {
        val i=Intent(from, RestaurantEditorActivity::class.java)
        i.setModel(restaurant)
        from.startActivity(i)
    }

    fun startRestaurantDetailsActivity(from : Context, restaurant : Restaurant)
    {
        val i=Intent(from, RestaurantDetailsActivity::class.java)
        i.setModel(restaurant)
        from.startActivity(i)
    }
}
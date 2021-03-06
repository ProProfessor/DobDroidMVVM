package ro.dobrescuandrei.demonewlibs.restaurant.details.headers

import android.content.Context
import android.util.AttributeSet
import ro.andreidobrescu.declarativeadapterkt.view.HeaderView
import ro.dobrescuandrei.demonewlibs.R
import ro.dobrescuandrei.demonewlibs.model.utils.FirstPageHeader


class FirstPageHeaderView : HeaderView<FirstPageHeader>
{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun layout(): Int = R.layout.header_first_page

    override fun setData(header : FirstPageHeader) {}
}
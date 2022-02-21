package uiwidgetsc.listview.recyclerview.adapters

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorationInRecyclerview(private val spanCount: Int, private val spacing: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildAdapterPosition(view)
        val col = pos % spanCount
        if (pos < spanCount) {
            outRect.top = spacing
        }
        outRect.bottom = spacing
        outRect.left = col * spacing / spanCount
        outRect.right = spacing - (col + 1) * spacing / spanCount
        if (pos >= spanCount) {
            outRect.top = spacing
        }
    }

}
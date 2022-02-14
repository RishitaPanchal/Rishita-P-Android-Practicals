package uiwidgetsc.listview.recyclerview.adapters

class APIResponse : ArrayList<DataClassExpandableRecyclerView>()

data class DataClassExpandableRecyclerView(
    var name: String,
    var realname: String,
    var team: String,
    var createdby: String,
    var firstappearance: String,
    var imageurl: String,
    var publisher: String,
    var bio: String,
    var expandable: Boolean = false
)

//Data class for expandable listview
data class DataExpandableListView(val moviename: String, val moviDetail:  List<String>) {}


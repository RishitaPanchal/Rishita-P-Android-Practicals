package uiwidgetsc.listview.recyclerview.adapters

class APIResponse : ArrayList<APIResponseItem>()

data class APIResponseItem(
    val bio: String,
    val createdby: String,
    val firstappearance: String,
    val imageurl: String,
    val name: String,
    val publisher: String,
    val realname: String,
    val team: String
)
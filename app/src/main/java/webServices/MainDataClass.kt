package webServices

import com.google.gson.annotations.SerializedName

/** Main Data class */
data class MainDataClass(
    var page: Int? = null,
    var perPage: Int? = null,
    var total: Int? = null,
    var totalPages: Int? = null,
    @SerializedName("data")
    var usersList: List<Data>,
    var support: Support? = Support()
)

/** Sub dataclass for data */
data class Data(
    var id: Int? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("first_name")
    var firstName: String? = null,
    @SerializedName("last_name")
    var lastName: String? = null,
    @SerializedName("avatar")
    var avatar: String? = null
)

/** Sub data class for support */
data class Support(
    var url: String? = null,
    var text: String? = null
)

/** Main dataclass for single user details */
data class SingleUserData(
    @SerializedName("data")
    val userList: Data,
    val support: Support
)
package gtcloud.yqbjgh.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampDicUsingStatus(

    @Id
    val nm: String,

    val xh: String,

    val mc: String

)
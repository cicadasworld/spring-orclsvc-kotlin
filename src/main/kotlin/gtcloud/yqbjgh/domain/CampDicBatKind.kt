package gtcloud.yqbjgh.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampDicBatKind(

    @Id
    val nm: String,

    val xh: String,

    val mc: String

)
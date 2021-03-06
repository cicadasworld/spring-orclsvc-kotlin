package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.CampWarehouse
import gtcloud.yqbjgh.repositories.CampDicWarKindRepository
import gtcloud.yqbjgh.repositories.CampWarehouseRepository
import gtcloud.yqbjgh.repositories.TxzhTsBddwmlRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CampWarehouseService {

    @Autowired
    lateinit var campWarehouseRepository: CampWarehouseRepository

    @Autowired
    lateinit var campDicWarKindRepository: CampDicWarKindRepository

    @Autowired
    lateinit var txzhTsBddwmlRepository: TxzhTsBddwmlRepository

    fun getCampWarehouse(campId: String): List<CampWarehouse> {
        return campWarehouseRepository.findByCampId(campId)
                .map { convert(it) }
    }

    fun convert(campWarehouse: CampWarehouse): CampWarehouse {
        val campDicWarKind = campDicWarKindRepository
                .findByIdOrNull(campWarehouse.warKind ?: "")

        val txzhTsBddwml = txzhTsBddwmlRepository
                .findByIdOrNull(campWarehouse.managementUnit ?: "")

        return campWarehouse.copy(
                warKind = campDicWarKind?.mc,  // warKind -> warKind����
                managementUnit = txzhTsBddwml?.mc  // managementUnit -> bd����
        )
    }
}
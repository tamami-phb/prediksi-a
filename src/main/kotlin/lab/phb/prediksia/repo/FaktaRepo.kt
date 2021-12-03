package lab.phb.prediksia.repo

import lab.phb.prediksia.model.Fakta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FaktaRepo: JpaRepository<Fakta, Int> {
}
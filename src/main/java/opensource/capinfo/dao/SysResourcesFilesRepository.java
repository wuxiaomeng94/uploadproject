package opensource.capinfo.dao;

import opensource.capinfo.entity.SysResourcesFilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysResourcesFilesRepository extends JpaRepository<SysResourcesFilesEntity,String> {


    List<SysResourcesFilesEntity> findByBusiIdAndFileUniqueCode(String busiId, String fileUniqueCode);

    List<SysResourcesFilesEntity> findByFileUniqueCodeAndFilesDynCode(String fileUniqueCode, String filesDynCode);

}
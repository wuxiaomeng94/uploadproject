package opensource.capinfo.service;

import opensource.capinfo.dao.SysResourcesFilesRepository;
import opensource.capinfo.entity.SysResourcesFilesEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * @ClassName SysResourcesFilesService
 * @Description TODO
 * @Author 消魂钉
 * @Date 7/2 0002 0:47
 */
@Service
public class SysResourcesFilesService {
    @Autowired
    private SysResourcesFilesRepository sysResourcesFilesRepository;
    @Transactional(readOnly = false)
    public void save(SysResourcesFilesEntity sysResourcesFilesEntity){
        sysResourcesFilesRepository.save(sysResourcesFilesEntity);

    };

    /**
     * 删除文件
     * @param key
     */
    @Transactional(readOnly = false)
    public boolean delete(String key) {
        //上传就上传上去吧，删除关联就可以了。
        if(StringUtils.isNotBlank(key)){
            SysResourcesFilesEntity entity = SysResourcesFilesEntity.builder().id(key).build();
            sysResourcesFilesRepository.delete(entity);
            return true;
        }
        return false;
    }


    public SysResourcesFilesEntity findById(String fileId) {
        return sysResourcesFilesRepository.getOne(fileId);
    }

    @Transactional(readOnly = true)
    public List<SysResourcesFilesEntity> findByBusiIdAndFileUniqueCode(String busiId, String fileUniqueCode) {
        return  sysResourcesFilesRepository.findByBusiIdAndFileUniqueCode(busiId, fileUniqueCode);
    }


    public List<SysResourcesFilesEntity> findByFileUniqueCodeAndFilesDynCode(String fileUniqueCode, String filesDynCode) {
        return sysResourcesFilesRepository.findByFileUniqueCodeAndFilesDynCode(fileUniqueCode, filesDynCode);
    }

}

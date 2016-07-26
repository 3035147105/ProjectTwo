package com.qilin.cms.dao.frame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * Created by gaohaiqing on 16-7-25.
 */
public class BaseEntityDao<T>{
    // Example的全路径名
    private final String examplePath;
    // Mapper的全路径名
    private final String mapperPath;

    public final Log log = LogFactory.getLog(this.getClass());

    private static final String MAPPER_PACKAGE_PATH = "com.qilin.cms.dao.mapper";
    private static final String EXAMPLE_PACKAGE_PATH = "com.qilin.cms.model";
    private static final String POINT = ".";

    /**
     * 约定大于配置，Dao命名规则，实体名+Dao
     */
    public BaseEntityDao() {
        mapperPath = new StringBuffer()
                .append(MAPPER_PACKAGE_PATH)
                .append(POINT)
                .append(getSimpleTName())
                .append("Mapper")
                .toString();
        log.info("==========mapperPath=====:"+ mapperPath);
        examplePath = new StringBuffer()
                .append(EXAMPLE_PACKAGE_PATH)
                .append(POINT)
                .append(getSimpleTName())
                .append("Example")
                .toString();
        log.info("==========examplePath=====:"+ examplePath);
    }

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<T> findAll(){
        try {
            return selectList(Class.forName(examplePath).newInstance());
        } catch (Exception e) {
            throw new RuntimeException("class loader failed | " + examplePath, e);
        }
    }

    public T get(long id){
        return this.sqlSession.selectOne(getMapperMethodPath("selectByPrimaryKey"), id);
    }


    public int insert(T entity){
        return this.sqlSession.insert(getMapperMethodPath("insert"), entity);
    }

    public int update(T entity){
        return this.sqlSession.update(getMapperMethodPath("updateByPrimaryKey"), entity);
    }

    public int delete(long id){
        return this.sqlSession.delete(getMapperMethodPath("deleteByPrimaryKey"), id);
    }

    /**
     * 按条件筛选集合
     * @param example
     * @return
     */
    public List<T> selectList(Object example){
        return this.sqlSession.selectList(getMapperMethodPath("selectByExample"), example);
    }

    /**
     * 分页查询
     */
    public List<T> selectList(Object example, int offset, int limit){
        RowBounds rowBounds = new RowBounds(offset, limit);
        return this.sqlSession.selectList(getMapperMethodPath("selectByExample"), example, rowBounds);
    }

    private String getSimpleTName() {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String[] strs = entityClass.getName().split("\\.");
        return strs[strs.length-1];
    }

    private String getMapperMethodPath(String methodName) {
        return new StringBuffer().append(mapperPath).append(POINT).append(methodName).toString();
    }
}

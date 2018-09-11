package xyz.yuzh.learn.spring.annotation.importselectors;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: yu_zh
 * @DateTime: 2018/09/10 17:15
 * <p>
 * 自定义 @Import 返回的组件类
 */
public class MyImportSelector implements ImportSelector {
    /**
     * @param annotationMetadata 当前标注@Import注解的类的所有注解信息
     * @return 导入到容器中的组件全类名 可以返回空数组，但是不能返回 null
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        /*Set<String> set = annotationMetadata.getAnnotationTypes();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        return new String[]{"xyz.yuzh.learn.spring.annotation.pojo.Blue", "xyz.yuzh.learn.spring.annotation.pojo.Yellow"};
    }
}

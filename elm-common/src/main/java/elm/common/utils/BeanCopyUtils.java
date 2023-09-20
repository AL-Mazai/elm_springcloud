package elm.common.utils;


import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils(){

    }

    /**
     * 单个Bean拷贝
     * @param source
     * @param clazz
     * @return
     * @param <V>
     */
    public static <V> V copyBean(Object source, Class<V> clazz){
        //创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            //实现属性拷贝
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }

    /**
     * 批量Bean拷贝
     * @param list
     * @param clazz
     * @return
     * @param <O>
     * @param <V>
     */
    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz){
       return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}

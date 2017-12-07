package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:运用反射获取类信息
 *
 * @author hailongchen
 *         Date: 2017-12-04
 *         Time: 10:35
 */
public class CustomizeClassUtil {

    /**
     * 获取类的信息,包括：
     * 1、类信息  2、成员变量  3、构造方法  4、成员方法
     */
    public void printClassDescription(Object obj) {

        //获取类的类类型
        Class c = obj.getClass();
        System.out.println(c);

        //打印类的名称
        System.out.println("类名:" + c.getName());
        //getMethods()返回所有的public的函数，包括父类继承而来的
        //getDeclaredMethods()返回该类所有声明的方法
        Method[] ms = c.getMethods();
        for (int i = 0; i < ms.length; i++) {
            //得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print("返回值类型" + returnType.getName() + " ");
            //得到方法名称
            System.out.print("方法名" + ms[i].getName() + "(");
            //获取参数类型（参数列表的类型的类类型）
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class pt : paramTypes) {
                System.out.print("参数类型的类类型" + pt.getName() + ",");
            }
            System.out.println(")");
        }

        //获取类的成员变量
        Field[] fields = c.getFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            String fieldName = field.getName();
            System.out.println("成员变量信息" + typeName + fieldName);
        }

    }

    public static void main(String[] args) {
        CustomizeClassUtil cu = new CustomizeClassUtil();
        CustomizeFileUtil customizeFileUtil = new CustomizeFileUtil();
        cu.printClassDescription(customizeFileUtil);
    }
}

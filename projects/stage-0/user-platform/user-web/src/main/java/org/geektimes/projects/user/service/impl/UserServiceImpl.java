package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }

    @Override
    public User queryUserByNameAndEmail(String name, String email){
        List<User> users = new ArrayList<User>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            // 执行查询语句（DML）
            String sql = "SELECT id,name,password,email,phoneNumber FROM users WHERE name = '" + name +"' or email = '"+ email +"'";

            ResultSet resultSet = statement.executeQuery(sql);
//            // BeanInfo
//            BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class, Object.class);
//            while (resultSet.next()) {  // 如果存在并且游标滚动
//                User user = new User();
//
//                // ResultSetMetaData 元信息
//
//
//                ResultSetMetaData metaData = resultSet.getMetaData();
//                System.out.println("当前表的名称：" + metaData.getTableName(1));
//                System.out.println("当前表的列个数：" + metaData.getColumnCount());
//                for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                    System.out.println("列名称：" + metaData.getColumnLabel(i) + ", 类型：" + metaData.getColumnClassName(i));
//                }
//
//                StringBuilder queryAllUsersSQLBuilder = new StringBuilder("SELECT");
//                for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                    queryAllUsersSQLBuilder.append(" ").append(metaData.getColumnLabel(i)).append(",");
//                }
//                // 移除最后一个 ","
//                queryAllUsersSQLBuilder.deleteCharAt(queryAllUsersSQLBuilder.length() - 1);
//                queryAllUsersSQLBuilder.append(" FROM ").append(metaData.getTableName(1));
//
//                System.out.println(queryAllUsersSQLBuilder);
//
//                // 方法直接调用（编译时，生成字节码）
////            user.setId(resultSet.getLong("id"));
////            user.setName(resultSet.getString("name"));
////            user.setPassword(resultSet.getString("password"));
////            user.setEmail(resultSet.getString("email"));
////            user.setPhoneNumber(resultSet.getString("phoneNumber"));
//
//                // 利用反射 API，来实现字节码提升
//
//                // User 类是通过配置文件，类名成
//                // ClassLoader.loadClass -> Class.newInstance()
//                // ORM 映射核心思想：通过反射执行代码（性能相对开销大）
//                for (PropertyDescriptor propertyDescriptor : userBeanInfo.getPropertyDescriptors()) {
//                    String fieldName = propertyDescriptor.getName();
//                    Class fieldType = propertyDescriptor.getPropertyType();
//                    String methodName = typeMethodMappings.get(fieldType);
//                    // 可能存在映射关系（不过此处是相等的）
//                    String columnLabel = mapColumnLabel(fieldName);
//                    Method resultSetMethod = ResultSet.class.getMethod(methodName, String.class);
//                    // 通过放射调用 getXXX(String) 方法
//                    Object resultValue = resultSetMethod.invoke(resultSet, columnLabel);
//                    // 获取 User 类 Setter方法
//                    // PropertyDescriptor ReadMethod 等于 Getter 方法
//                    // PropertyDescriptor WriteMethod 等于 Setter 方法
//                    Method setterMethodFromUser = propertyDescriptor.getWriteMethod();
//                    // 以 id 为例，  user.setId(resultSet.getLong("id"));
//                    setterMethodFromUser.invoke(user, resultValue);
//                }
//                System.out.println(user);
//                users.add(user);
//            }
            connection.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return users.get(0);
    }

    private Connection getConnection() throws SQLException{
        String databaseURL = "jdbc:derby:/db/user-platform;create=true";
        Connection connection = DriverManager.getConnection(databaseURL);
        return connection;
    }

    /**
     * 数据类型与 ResultSet 方法名映射
     */
    static Map<Class, String> typeMethodMappings = new HashMap<>();

    static {
        typeMethodMappings.put(Long.class, "getLong");
        typeMethodMappings.put(String.class, "getString");
    }

    private static String mapColumnLabel(String fieldName) {
        return fieldName;
    }
}

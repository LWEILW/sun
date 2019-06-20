package com.sunshine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SunApplicationTests {

    @Test
    public void contextLoads() {

    }

//    @Test
//    public void insertItemNum() {
//        String itemNum = "FZ01010600010102";
//        String[] data = new String[7];
//        data[0] = itemNum.substring(0, 2);
//        data[1] = itemNum.substring(2, 4);
//        data[2] = itemNum.substring(4, 6);
//        data[3] = itemNum.substring(6, 8);
//        data[4] = itemNum.substring(8, 12);
//        data[5] = itemNum.substring(12, 14);
//        data[6] = itemNum.substring(14, 16);
//        int a = 0;
//        for (int i = 0; i < 7; i++) {
//            System.out.println(data[i]);
//
//            String sql = "";
//            if (true) {
//                // 有值
//            } else {
//                a = i;
//                break;
//            }
//
//
//            break;
//            switch (i) {
//                case 1:
//                    // 查询 "select * from Item where  ='" + data[0] + "'";
//                    if (true) {
//                        // 获取第一个ID
//                    } else {
//                        break;
//                    }
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//                case 5:
//                    break;
//                case 6:
//                    break;
//                case 7:
//                    break;
//            }
//        }
//
//
//        for (int a = 0; a < 7; a++) {
//
//        }
//
//
//        String sql = "select count(*) from Item where  ='" + data[0] + "'";
//        int count = 1;
//        // 存在
//        if (count == 1) {
//            String sql = "select count(*) from Item where  ='" + data[0] + "'";
//            if () {
//                String sql = "select count(*) from Item where  ='" + data[0] + "'";
//                if () {
//
//                } else {
//
//                }
//            } else {
//
//            }
//        } else {
//            System.out.println("第一个不存在");
//            // 不存在添加
//            for (int i = 0; i < 7; i++) {
//                String sql1 = "insert into item () values () ";
//                System.out.println(data[i]);
//            }
//        }
//
//
//    }
//
//
//    private static int insterClassification(String itemNum, Connection conn) {
//        String[] data = new String[7];
//        data[0] = itemNum.substring(0, 2);
//        data[1] = itemNum.substring(2, 4);
//        data[2] = itemNum.substring(4, 6);
//        data[3] = itemNum.substring(6, 8);
//        data[4] = itemNum.substring(8, 12);
//        data[5] = itemNum.substring(12, 14);
//        data[6] = itemNum.substring(14, 16);
//
//
//        ItemClassification itemClassification = new ItemClassification();
//        String classificationId = null;
//        boolean status = false;
//        int num = 0;
//        for (int i = 0; i < 7; i++) {
//            num = i;
//            // 查询第一个值CLASS_CODE是否存在
//            String sql = "select * from ITEM_CLASSIFICATION where  CLASS_CODE ='" + data[i] + "' and PARENT_CLASS='" + classificationId + "'";
//            itemClassification = getClassification(sql, conn);
//            if (itemClassification != null) {
//                classificationId = itemClassification.getId();
//                System.out.println(classificationId);
//            } else {
//                // 插入数据
//                status = true;
//                num=i;
//                break;
//            }
//
//        }
//        if (status) {
//            for (int a = num; a < 7; a++) {
//                sql = "insert into ITEM_CLASSIFICATION () values()";
//                getClassification(sql, conn);
//
//            }
//        }
//
//
//        for (int i = 0; i < 7; i++) {
//            System.out.println(data[i]);
//            if (status) {
//                break;
//            }
//            switch (i) {
//                case 0:
//                    // 查询第一个值CLASS_CODE是否存在
//                    sql = "select * from ITEM_CLASSIFICATION where  CLASS_CODE ='" + data[0] + "'";
//                    itemClassification = getClassification(sql, conn);
//                    if (itemClassification != null) {
//                        classificationId = itemClassification.getId();
//                        System.out.println(classificationId);
//                    } else {
//                        // 插入数据
//                        status = true;
//                    }
//                    break;
//                case 1:
//                    // 查询第二个值CLASS_CODE是否存在
//                    sql = "select * from ITEM_CLASSIFICATION where  CLASS_CODE ='" + data[1] + "' and PARENT_CLASS='" + classificationId + "'";
//                    itemClassification = getClassification(sql, conn);
//                    if (itemClassification != null) {
//                        classificationId = itemClassification.getId();
//                        System.out.println(classificationId);
//                    } else {
//                        // 插入数据
//                        status = true;
//                    }
//                    break;
//                case 2:
//                    // 查询第二个值CLASS_CODE是否存在
//                    sql = "select * from ITEM_CLASSIFICATION where  CLASS_CODE ='" + data[2] + "' and PARENT_CLASS='" + classificationId + "'";
//                    itemClassification = getClassification(sql, conn);
//                    if (itemClassification != null) {
//                        classificationId = itemClassification.getId();
//                        System.out.println(classificationId);
//                    } else {
//                        // 插入数据
//                        status = true;
//                    }
//                    break;
//                case 3:
//                    // 查询第二个值CLASS_CODE是否存在
//                    sql = "select * from ITEM_CLASSIFICATION where  CLASS_CODE ='" + data[3] + "' and PARENT_CLASS='" + classificationId + "'";
//                    itemClassification = getClassification(sql, conn);
//                    if (itemClassification != null) {
//                        classificationId = itemClassification.getId();
//                        System.out.println(classificationId);
//                    } else {
//                        // 插入数据
//                        status = true;
//                    }
//                    break;
//                case 4:
//                    // 查询第二个值CLASS_CODE是否存在
//                    sql = "select * from ITEM_CLASSIFICATION where  CLASS_CODE ='" + data[4] + "' and PARENT_CLASS='" + classificationId + "'";
//                    itemClassification = getClassification(sql, conn);
//                    if (itemClassification != null) {
//                        classificationId = itemClassification.getId();
//                        System.out.println(classificationId);
//                    } else {
//                        // 插入数据
//                        status = true;
//                    }
//                    break;
//                case 5:
//                    // 查询第二个值CLASS_CODE是否存在
//                    sql = "select * from ITEM_CLASSIFICATION where  CLASS_CODE ='" + data[5] + "' and PARENT_CLASS='" + classificationId + "'";
//                    itemClassification = getClassification(sql, conn);
//                    if (itemClassification != null) {
//                        classificationId = itemClassification.getId();
//                        System.out.println(classificationId);
//                    } else {
//                        // 插入数据
//                        status = true;
//                    }
//                    break;
//                case 6:
//                    // 查询第二个值CLASS_CODE是否存在
//                    sql = "select * from ITEM_CLASSIFICATION where  CLASS_CODE ='" + data[6] + "' and PARENT_CLASS='" + classificationId + "'";
//                    itemClassification = getClassification(sql, conn);
//                    if (itemClassification != null) {
//                        classificationId = itemClassification.getId();
//                        System.out.println(classificationId);
//                    } else {
//                        // 插入数据
//                        status = true;
//                    }
//                    break;
//            }
//        }
//
//
//        for (int a = 0; a < 7; a++) {
//
//        }
//
////        close(conn);
//        return 1;
//    }

}

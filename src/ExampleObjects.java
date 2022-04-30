//package com.onik.spring.security.jwt.Entities;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExampleObjects {
//
//    public static void main(String[] args) {
//        UserEntity userEntity = new UserEntity();
//        RoleEntity r1 = new RoleEntity();
//        RoleEntity r2 = new RoleEntity();
//
//        List<RoleEntity> roleEntities = new ArrayList<>();
//        roleEntities.add(r1);
//        roleEntities.add(r2);
//
//        List<UserRoleEntity> userRole = new ArrayList<>();
//        for (RoleEntity roleEntity : roleEntities) {
//            UserRoleEntity userRoleEntity = new UserRoleEntity();
//            userRoleEntity.setUser(userEntity);
//            userRoleEntity.setRole(roleEntity);
//            userRole.add(userRoleEntity);
//        }
//        System.out.println(userRole.toString());
//
//    }
//}

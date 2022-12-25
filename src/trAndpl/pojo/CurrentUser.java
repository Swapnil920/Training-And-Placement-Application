/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.pojo;

/**
 *
 * @author Dell
 */
public class CurrentUser {

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CurrentUser.name = name;
    }

    public static String getUserId() {
        return UserId;
    }

    public static void setUserId(String UserId) {
        CurrentUser.UserId = UserId;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        CurrentUser.id = id;
    }

    public static String getType() {
        return Type;
    }

    public static void setType(String Type) {
        CurrentUser.Type = Type;
    }
    private static String name;
    private static String UserId;
    private static String id;
    private static String Type;
}
    


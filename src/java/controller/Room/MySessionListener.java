/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Room;

/**
 *
 * @author Dai Nhan
 */
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Xóa hết các thuộc tính session mà bạn muốn ở đây
        se.getSession().removeAttribute("user");
        se.getSession().removeAttribute("status");
        se.getSession().removeAttribute("list");
        se.getSession().removeAttribute("room");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Không cần triển khai phương thức này, vì chúng ta chỉ quan tâm đến việc xóa session
    }
}

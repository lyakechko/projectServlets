package com.example.demo.Validation;

import com.example.demo.DAO.CreateObjects;
import com.example.demo.DBO.UserInfo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Validator {
    protected static String regExpPassword = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    protected static String regExpPasswordHint = "Строчные и прописные латинские буквы, цифры, спецсимволы. Минимум 8 символов";
    protected static String notEqualPasswords = "Пароль и повтор пароля не совпадают";
    protected static String someDataIsEmpty = "Некорректно введены данные";
    public static String successSave = "Данные успешно сохранены. Пройдите авторизацию";
    protected static String loginAlreadyExist = "Логин уже занят";
    protected static String globalError = "Что-то пошло не так";
    protected static String codeNotFound = "Код администратора не найден в системе";
    protected static String incorrectData = "Неверно введён логин или пароль";
    protected static String errorGetUserInfo = "Ошибка получения клиента";
    protected static Long sessionlLifeTime = 120000L;
    protected static String codeAdministrator = "2j$d2^3#";

    public static void generalMethodHandlingRequests(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        processingRequest(req, resp);
    }


    private static void processingRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String login = req.getParameter("loginAut");
        String password = req.getParameter("passwordAut");
        if (StringUtils.isBlank(login) && StringUtils.isBlank(password)) {
            Map<String, String> map = addDataRequestTomap(req);
            try {
                if (map.values().stream().anyMatch(StringUtils::isBlank)) {
                    map.values().forEach(System.out::println);
                    System.out.println("1");
                    allertExecuteIndex(out, someDataIsEmpty);
                    return;
                }
                Set<UserInfo> userInfoList = CreateObjects.getUserInfoList();
                if (userInfoList.stream().filter(Objects::nonNull).map(userInfo -> userInfo.getLogin()).
                        filter(Objects::nonNull).anyMatch(loginUserInfo -> map.get("login").equals(loginUserInfo))) {
                    System.out.println("2");
                    allertExecuteRegistration(out, loginAlreadyExist);
                    return;
                }
                if (!map.get("password").matches(regExpPassword)) {
                    System.out.println("3");
                    allertExecuteRegistration(out, regExpPasswordHint);
                    return;
                }
                if (!map.get("password").equals(map.get("passwordDouble"))) {
                    System.out.println("4");
                    allertExecuteRegistration(out, notEqualPasswords);
                    return;
                } else {
                    if (Objects.nonNull(req.getAttribute("codeForAdmin"))) {
                        if (codeAdministrator.equals(req.getAttribute("codeForAdmin"))) {
                            CreateObjects.saveAdministrator(map);
                            map.values().forEach(System.out::println);
                            allertExecuteIndex(out, successSave);
                            return;
                        } else {
                            allertExecuteRegistration(out, codeNotFound);
                            return;
                        }
                    }
                    System.out.println("5");
                    CreateObjects.saveUser(map);
                    map.values().forEach(System.out::println);
                    allertExecuteIndex(out, successSave);
                    return;
                }
            } catch (Exception exception) {
                System.out.println("6");
                allertExecuteIndex(out, globalError);
                return;
            }
        } else {
            if (CreateObjects.getUserInfoList().stream().filter(Objects::nonNull).
                    filter(userInfo -> login.equals(userInfo.getLogin())).
                    anyMatch(userInfo -> password.equals(userInfo.getPassword()))) {
                UserInfo userInfo = CreateObjects.getUserInfoList().stream().filter(Objects::nonNull).
                        filter(userInfoFilter -> login.equals(userInfoFilter.getLogin())).
                        filter(userInfoFilter -> password.equals(userInfoFilter.getPassword())).
                        findFirst().orElse(null);

                if (Objects.isNull(userInfo)) {
                    allertExecuteIndex(out, errorGetUserInfo);
                    return;
                }
                String allUser = CreateObjects.getUserInfoList().isEmpty() ?
                        "Данные не получены" : String.valueOf(CreateObjects.getUserInfoList().size());
                HttpSession session = req.getSession();
                session.setAttribute("login", userInfo.getLogin());
                session.setAttribute("fullName", userInfo.getName() + " " + userInfo.getSurname());
                req.getServletContext().setAttribute("allUsers", allUser);
                userInfo.setTimeLastAction(System.currentTimeMillis());
                CreateObjects.updateUserInfo(userInfo);
                System.out.println(req.getMethod()+"------");
                int page = 1;
                int recordsPerPage = 3;
                if (req.getParameter("page") != null)
                    page = Integer.parseInt(req.getParameter("page"));

                List<UserInfo> list = CreateObjects.userInfoList(page,  recordsPerPage);
                System.out.println("-----------");
                System.out.println(list);
                System.out.println("-----------");
                int noOfRecords = 0;
                int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
                req.setAttribute("userInfoList", list);
                req.setAttribute("noOfPages", noOfPages);
                req.setAttribute("currentPage", page);
                req.getServletContext().getRequestDispatcher("/authorizationPage.jsp").forward(req, resp);
            } else {
                allertExecuteIndex(out, incorrectData);
            }
        }
    }

    private static void allertExecuteIndex(PrintWriter out, String message) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + message + "');");
        out.println("location='index.jsp';");
        out.println("</script>");
    }

    private static void allertExecuteRegistration(PrintWriter out, String message) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + message + "');");
        out.println("location='registration.jsp';");
        out.println("</script>");
    }

    private static HashMap<String, String> addDataRequestTomap(HttpServletRequest req) {
        HashMap hashMap = new HashMap<>();
        hashMap.put("name", req.getParameter("name"));
        hashMap.put("surname", req.getParameter("surname"));
        hashMap.put("login", req.getParameter("login"));
        hashMap.put("password", req.getParameter("password"));
        hashMap.put("passwordDouble", req.getParameter("passwordDouble"));
        hashMap.put("resident", req.getParameter("resident"));
        return hashMap;
    }
}

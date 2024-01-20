<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Erreur de connexion à la base de donnée</p>

</body>
</html>

(
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/pizzainnodb?useSSL=false", "root", "");
        		
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, pizza.getName());
            preparedStatement.setString(3, pizza.getDescription());
            preparedStatement.setInt(4, pizza.getPrix());
            System.out.println(preparedStatement);
            
            result = preparedStatement.executeUpdate();

        }
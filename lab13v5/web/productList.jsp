<%--
  Created by IntelliJ IDEA.
  User: tek
  Date: 7/13/19
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>

    <link type="text/css" href="resources/css/style.css" rel="stylesheet">
    <link type="text/css" href="resources/css/addToCart.scss" rel="stylesheet">
    <link type="text/css" href="resources/css/addToCartCSS.css" rel="stylesheet">
    <link type="text/css" href="resources/css/shoppingCart.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script type="text/javascript" src="resources/js/productList.js"></script>
</head>
<body>
<div id="banner"><img src="resources/images/kelati.png" alt=""></div>
 <div class="shoppingCart"><span id="counter"><c:out value="${cartSize}"/></span><br/><img src="resources/images/shoppingCart.png" alt=""></div>

<c:forEach items="${products}" var="product" varStatus="status">
    <div class="productArea">
        <div class="imageArea"><img src="resources/images/2.jpg" alt=""/></div>
        <diV>
        <table>
            <tbody>
            <tr>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.description}"/></td>

                <td><c:out value="${product.price}"/></td>

                <td >
                    <button class="btn-add" value="${product.id}"><c:set var="pID" value="${product.id}"/> Add To Cart </button>
                 <!--  <label class="btn-add"> <button class="button-hover-addcart button"><span>Add to cart</span><i class="fa fa-shopping-cart"></i></button></label> -->



                </td>
            </tr>
            </tbody>
        </table>
        </diV>
    </div>
</c:forEach>


    <div class="cartPopUp">


            <table id="cartDisplay">
                <thead>
                <tr>
                     <td>ID</td>
                    <td> Item Name</td>

                    <td> price </td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartProducts}" var="product" varStatus="status">

                    <tr>
                        <td><c:out value="${product.id}"/></td>
                        <td><c:out value="${product.name}"/></td>

                        <td><c:out value="${product.price}"/></td>

                        <td>
                            <input type="button" class="btn-remove" value="remove"/>
                        </td>

                    </tr>
                </c:forEach>

                </tbody>
            </table> <br/>

   <input id="cancel" type="button"  value="Cancel"> <a href="checkout"> Checkout</a>



    </div>
</body>
</html>

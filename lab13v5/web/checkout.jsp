<%--
  Created by IntelliJ IDEA.
  User: tek
  Date: 7/13/19
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="resources/css/style.css" rel="stylesheet">
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script type="text/javascript" src="resources/js/productList.js"></script>



    <link href="resources/css/billing.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"   integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="   crossorigin="anonymous"></script>
    <script src="resources/js/billing.js"></script>
</head>
<body>
<div id="banner"><img src="resources/images/kelati.png" alt=""></div>
<div id="adminPanel"><span>Check Out Summary</span></div>
  <hr/>
<div>
<table id="cartCheckout" border="1">
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
          <!--
            <td>
                <input type="button" class="btn-remove" value="remove"/>
            </td>
   -->
        </tr>
    </c:forEach>

    </tbody>
</table> <br/>
</div>
 <hr/>
<h2> Cart Total $ <span id="totalPrice"><c:out value="${totalPrice}"/></span></h2>



 <form name="bill-form" method="POST">
    <div id="main">
        <div id="header">
            <h3>Shiping and Payment</h3>
        </div>
        <div class="row" id="div1">
            <div class="col-md-4">
                <input type="text" name="city" placeholder="Ciity" onkeyup ="lettersOnly(this)" required/>
            </div>
            <div class="col-md-4">
                <input type="text" name="state"  placeholder="State (two letters)" onkeyup ="lettersOnly(this)" required/>
            </div>
            <div class="col-md-4">
                <input type="text" name="country" placeholder="Country" onkeyup ="lettersOnly(this)" required/>
            </div>
        </div>

        <div class="row">

            <div class="col-md-4">
                <input type="text" name="st-num" placeholder="Street-Number" onkeyup = "numOnly(this)" required />
            </div>
            <div class="col-md-4">
                <input type="text" name="address" placeholder="Address-line 1" required/>
            </div>
            <div class="col-md-4">
                <input type="text" name="address2" placeholder="Address-line 2"/>
            </div>

        </div>

        <fieldset>
            <legend>Card type</legend>
            <div class="row">

                <div class="col-md-4">
                    <input type="radio" name="card" />  <img src="resources/images/master.png" width="70px" />
                </div>

                <div class="col-md-4">
                    <input type="radio" name="card" /> <img src="resources/images/visa.png" width="60px" />
                </div>
                <div class="col-md-4">
                    <input type="radio" name="card" />  <img src="resources/images/amex.png" width="60px" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <input type="number" name="card-num" placeholder="Card-Number"  onkeyup = "numOnly(this)" required/>
                </div>

                <div class="col-md-4">
                    <input type="number" name="scv" placeholder="Security-code"  onkeyup = "numOnly(this)" required/>
                </div>
                <div class="col-md-4">
                    <input type="checkbox" id="hide" onchange="checkb()"> Shiping Address is deferent from Billing Address.</input>
                </div>

            </div>
        </fieldset>

        <div id="id1">


            <div class="row">
                <div class="col-md-4">
                    <input type="text" name="city" placeholder="Ciity" onkeyup ="lettersOnly(this)" required/>
                </div>
                <div class="col-md-4">
                    <input type="text" name="state"  placeholder="State (two letters)" onkeyup ="lettersOnly(this)" required/>
                </div>
                <div class="col-md-4">
                    <input type="text" name="country" placeholder="Country" onkeyup ="lettersOnly(this)" required/>
                </div>
            </div>
            <div class="row">

                <div class="col-md-4">
                    <input type="text" name="st-num" placeholder="Street-Number" onkeyup = "numOnly(this)" required />
                </div>
                <div class="col-md-4">
                    <input type="text" name="address" placeholder="Address-line 1" required/>
                </div>
                <div class="col-md-4">
                    <input type="text" name="address2" placeholder="Address-line 2"/>
                </div>

            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <%--                <input type="button" name="orderbtn" id="btn" value="Place Order" />--%>
                <button id="btn"> Place Order</button>
            </div>
        </div>
    </div>
    <div id="message-box">
        <p id="message">

        </p>
        <a href="products"> Continute shopping ... </a>
        <form action="logout" method="post">

            <input type="submit" name="logout" value="logout">
        </form>
    </div>
    <%--</form>--%>
</body>
</html>

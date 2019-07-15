<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Contact</title>
    <link type="text/css" href="resources/css/style.css" rel="stylesheet">
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script type="text/javascript" src="resources/js/script.js"></script>

</head>
<body>

<div id="banner"><img src="resources/images/kelati.png" alt=""></div>
<div id="adminPanel"><span>Admin Panel</span></div>
<hr/>
<table id="tbl_products" border="1">
    <thead>
    <tr>
        <th>S.NO</th>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Stock</th>
        <th>Supplier</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach items="${products}" var="product" varStatus="status">

        <tr>
            <td><c:out value="${status.count}"/></td>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.stock}"/></td>
            <td><c:out value="${product.supplier}"/></td>
            <td><c:out value="${product.price}"/></td>

            <td>
                <button class="del" value="${product.id}"><c:set var="pID" value="${product.id}"/> Delete</button>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<div><a href="/lab13v4_war_exploded">Refresh</a>
    <button href="" class="button3">Add Product</button>
</div>
<div id="homepageLink"><a href="/lab13v4_war_exploded/productList">Home Page </a></div>
<!-- <form class="addProduct" action="upload" method="post" enctype="multipart/form-data"> --!>
<div class="addProduct">
    <fieldset>
        <legend> Add Product here</legend>
        <div>
            <label for="product_id">Id</label> <input type="text" id="product_id"
                                                      readonly="readonly" placeholder="Id"/>
        </div>
        <div>
            <label for="product_name">Name</label> <input type="text" id="product_name"
                                                          placeholder="Name"/>
        </div>
        <div>
            <label for="product_description">Description</label> <input type="text" id="product_description"
                                                                        placeholder="Description"/>
        </div>

        <div>
            <label for="product_stock">Stock</label> <input type="text" id="product_stock"
                                                            placeholder="Stock"/>
        </div>

        <div>
            <label for="product_supplier">Supplier</label> <input type="text" id="product_supplier"
                                                                  placeholder="Supplier"/>
        </div>


        <div>
            <label for="product_price">Price</label> <input type="text" id="product_price"
                                                            placeholder="Price"/>
        </div>


        <input id="btn_add" type="submit" value="Submit"/>


    </fieldset>


</div>
</body>
</html>
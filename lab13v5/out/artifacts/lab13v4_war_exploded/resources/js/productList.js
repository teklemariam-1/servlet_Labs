$(function () {

        //  alert("java script is Loaded")

        //$(".btn-add").click(shoppingCart())

        $(".check").click(shoppingCart);

        function shoppingCart(event) {
            // alert("love clicked")
            // alert($(event.target).val());

            // $.post('productDelete', {productID: $(event.target).val()}, processData, "json")
        }

        $(".btn-add").click(shoppingCartAdd)

        function shoppingCartAdd(event) {
          //  alert("button shopping cart clicked")
           // alert($(event.target).val());
          //  alert(event.target.nodeName);
            $.post('cart', {productID: $(event.target).val()}, processData, "json")
        }

        //     var counter = 0;
        // function processData(data) {
        //    $("#counter").text(counter+1);
        //  alert("cart is returned")
        //     alert(data.name);
        //     var td0 = $('<td>').text(data.name);
        //
        //     var td1 = $('<td>').text(data.price);
        //     var tr = $('<tr>').append(td0).append(td1);
        //     var r= $('<input type="button" class="btn-remove" value="remove"/>');
        //     $("body").append(r);
        //     $('#cartDisplay>tbody').append(tr);
        //
        //     $( "body tr" ).each(function() {
        //         $( this ).append( r);
        //     });
        //
        //    // $("#counter").text('<c:out value=\"${cartSize}\"/>');
        //
        // }

        function processData(data) {

            var data1 = data[0];
            var data2 = data[1];
            //$("#counter").text(counter + 1);
           // alert("cart is returned")
           // alert("size of cart is " + data2);
            $("#counter").text(data2);
            // alert(data.name);

                 var td =   $('<td>').text(data1.id);
                var td0 = $('<td>').text(data1.name);
               // alert("Akile");

                var td1 = $('<td>').text(data1.price);
                var tr = $('<tr>').append(td0).append(td1);
                var r = $('<button class="btn-remove"> Remove</button>');
                $("body").append(r);
                $('#cartDisplay>tbody').append(tr);

                $("body tr").each(function () {
                    $(this).append(r);
                });



        }

        // diplaying cart pup UP..

        $(".shoppingCart").click(cartPopUp);

        function cartPopUp() {
            // alert("cart will show up")
            $(".cartPopUp").toggle();
            // alert( $(".shoppingCart").toggle();
        }

        $("#cancel").click(hideCart);

        function hideCart() {
            $(".cartPopUp").css("display", "none");

        }

        // removing from cart

      $(".btn-remove").click(removeFromCart);

       function removeFromCart(event){

           event.stopPropagation();
           event.stopImmediatePropagation();
            alert("remove")

         //  $(event.target).parent().closest('tr').remove();
           var ele = $(this).closest('tr')
          var id =  ele.find(">:first-child").text();

           alert(id);

           $.get('cart', {productID: id},afterItemRemoval, "json")

           $(this).closest('tr').remove();

       }

           function  afterItemRemoval(data) {
                alert("item removed")

               $("#counter").text(data);

           }







    }
)





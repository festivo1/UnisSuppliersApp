<%@include file="../../admin_shared/header.jsp" %>

<div class="container">
    <div class="col-md-6">
        <div class="form-area">  
            <form role="form" method="post" name ="transactionDTO"  action="${SITE_URL}/transactions/save">
                <br style="clear:both">
                <h3 style="margin-bottom: 25px;"> Add Transactions: ${dipo.getName()}</h3>
                <h2> </h2>
                <div>

                    <label>Supplier</label>
                    <select class="form-control" id="sid" name="sid"  required>
                        <option value="">select supplier</option>
                        <c:forEach var="supplier" items="${suppliers}">
                            <option value="${supplier.id}" > ${supplier.name}</option> 
                        </c:forEach>
                    </select>
                </div>
                <!--                <div class="form-group">
                                    <label>Dipo</label>
                                    <input  class="form-control" id="dipo" name="did" value="">
                                   
                                </div>-->
                <div>

                    <label>item</label>
                    <select class="form-control" id="iid" name="iid"  required>
                        <option value="">select item</option>
                        <c:forEach var="item" items="${items}">
                            <option value="${item.id}" > ${item.name}</option> 
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label>Dipo</label>
                    <input type="text" class="form-control"  id="did" name="did" value="${dipo.getId()}" />
                </div>
                <div class="form-group col-md-4">
                    <label>itemRefilled</label>
                    <input type="text" class="form-control" id="itemRefilled" value="0" name="itemRefilled"/>
                </div>
                <div class="form-group col-md-4">
                    <label>itemReceived</label>
                    <input type="text" class="form-control" id="itemReceived" name="itemReceived" value="0"  />
                </div>
                <div class="form-group col-md-4">
                    <label>itemSold</label>
                    <input type="text" class="form-control" id="itemSold" name="itemSold" value="0" />
                </div>

                <div class="row">
                    <div class="form-group col-md-3">
                        <label>receivedAmount</label>
                        <input type="text" class="form-control" id="receivedAmount" name="receivedAmount" value="0"  >
                    </div>

                    <div class="form-group col-md-3">
                        <label>refilledAmount</label>
                        <input type="text" class="form-control" id="refilledAmount" name="refilledAmount" value="0"  >
                    </div>



                    <div class="form-group col-md-3">
                        <label>leakageReceived</label>
                        <input type="text" class="form-control" id="leakageReceived" name="leakageReceived" value="0" >
                    </div>

                    <div class="form-group col-md-3">
                        <label>leakageRefilled</label>
                        <input type="text" class="form-control" id="leakageRefilled" name="leakageRefilled" value="0"  >
                    </div>
                </div>


                <div>
                    <input  name="id" value="0"/>
                </div>
                <button type="submit" name="submit" value="save " class="btn btn-success">save</button>

                <button type="button" id="submit" name="submit" class="btn btn-primary ">save & continue </button>
                <a href="${SITE_URL}/dipos" type="button" class="btn btn-danger" name="back" class="btn btn-default ">Back</a>

            </form>
        </div>
    </div>
</div>
    <%@include file="../../admin_shared/footer.jsp" %>
<%@include file="../../admin_shared/header.jsp"%>
<div class="container">

    <div class="row">
        <div class="panel panel-default filterable">
            <div class="panel-heading">
                <h3 class="panel-title">ITEMS</h3>
                <div class="pull-right">

                    <a href="${SITE_URL}/item/create" type= "button" class="btn btn-xs btn-primary ">
                        <span class="glyphicon glyphicon-plus">
                    </a>
                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span> Filter</button>
                </div>
            </div>
            <table class="table table-condensed table-hover table-striped table-bordered table-responsive table-list">
                <thead>
                    <tr class="filters">
                        <th><input type="text" class="form-control" placeholder="id" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Name" disabled></th>
                        <th><input type="text" class="form-control" placeholder="price" disabled></th>
                        <th><input type="text" class="form-control" placeholder="AddedDate" disabled></th>
                        <th>Action</th>
                        


                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${items}">

                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${dipo.addedDate}</td>
                            <td align="">
                                <a href="${SITE_URL}/admin/item/edit/${dipo.id}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"> </span>    </a>
                                <a href="${SITE_URL}/admin/item/delete" class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span>    </a>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@include file="../../admin_shared/footer.jsp"%>

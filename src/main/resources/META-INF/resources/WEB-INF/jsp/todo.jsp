<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
        <div class="container">
            <h1>Enter Todo Details</h1>
            <form:form method="post" modelAttribute ="todo">
<%--                We can move same element in one fieldset--%>
                <fieldset class="mb-3">
    <%--                This is the lable for the description field--%>
                    <form:label path="description">Description</form:label>
    <%--                This is for the text--%>
                    <form:input type="text" path="description" required="required"/>
    <%--                This is Error of the field--%>
                    <form:errors path="description" cssClass="text-warning "/>
                </fieldset>
                
                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type= "text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>



                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
                <input type="submit" class="btn btn-success"/>
            </form:form>
        </div>

    <%@include file="common/footer.jspf"%>

    <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
        });
    </script>

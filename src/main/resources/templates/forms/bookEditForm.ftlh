<#import "/spring.ftl" as spring />

<h4 class="mb-3">Edit Book</h4>
<form action="/books/edit" method="post">

    <input type="hidden" name="id" value="${book.id}">

    <div class="mb-3">
        <label for="title">Title</label>
        <div class="input-group">
            <input type="text" class="form-control" id="title" name="title" value="${book.title}">
        </div>
    </div>

    <div class="mb-3">
        <label for="category">Category</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="category" name="category">
                <#if booksCategories??>
                    <#list booksCategories as category>
                        <option value="${category}"<#if book.category == category> selected</#if>>${category}</option>
                    </#list>
                </#if>
            </select>
        </div>
    </div>

    <div class="mb-3">
        <label for="author-first-name">Author First Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="author-first-name" name="authorFirstName"
                   value="${book.authorFirstName}" readonly>
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Author Last Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="author-last-name" name="authorLastName"
                   value="${book.authorLastName}" readonly>
        </div>
    </div>


    <div class="mb-3">
        <label for="datepicker">Date</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker" name="publicationDate"
                   value="${book.publicationDate}">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Comment</label>
        <div class="input-group">
            <input type="text" class="form-control" id="comments" name="comments" value="${book.comments!''}">
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Update</button>
</form>
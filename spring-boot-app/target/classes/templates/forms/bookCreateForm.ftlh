<#import "/spring.ftl" as spring />

<h4 class="mb-3">Add a Book</h4>

<form id="createForm" action="/books/create" method="post">

    <div class="mb-3">
        <label for="title">Title</label>
        <div class="input-group">
            <input type="text" class="form-control" id="title" name="title" placeholder="Book's title">
        </div>
    </div>

    <div class="mb-3">
        <label for="category">Category</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="category" name="category">
                <#if booksCategories??>
                    <#list booksCategories as category>
                        <option value="${category}">${category}</option>
                    </#list>
                </#if>
            </select>
        </div>
    </div>

    <div class="mb-3">
        <label for="author-first-name">Author First Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="author-first-name" name="authorFirstName" placeholder="Type first name">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Author Last Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="author-last-name" name="authorLastName" placeholder="Type last name">
        </div>
    </div>

    <div class="mb-3">
        <label for="isbn">ISBN</label>
        <div class="input-group">
            <input type="text" class="form-control" id="isbn" name="isbn" placeholder="Type the 10 digit ISBN">
        </div>
    </div>

    <div class="mb-3">
        <label for="datepicker">Date</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker" name="publicationDate" placeholder="When was the book published">
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Add the book</button>
</form>
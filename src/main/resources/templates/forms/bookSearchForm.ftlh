<#import "/spring.ftl" as spring />

<h4 class="mb-3">Search book by author's name (case sensitive)</h4>

<form action="/search" method="post">
    <div class="mb-3 mt-4">
        <label for="datepicker">Author's name or surname</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="book-open"></span></span>
            </div>
            <input type="text" class="form-control" id="author" name="author">
        </div>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
<#assign page = springMacroRequestContext.requestUri>
<nav class="col-md-2 col-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">

            <li class="nav-item">
                <a class="nav-link <#if page == '/'> active</#if>" href="/">
                    <span data-feather="book"></span>
                    Books
                </a>
            </li>

            <li class="nav-item ">
                <a class="nav-link <#if page == '/search'> active</#if>" href="/search">
                    <span data-feather="search"></span>
                    Search for Books
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link <#if page == '/books/create'> active</#if>" href="/books/create">
                    <span data-feather="plus-circle"></span>
                    Add Book
                </a>
            </li>
        </ul>

    </div>
</nav>
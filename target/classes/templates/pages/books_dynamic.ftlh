<#import "/spring.ftl" as spring />
<html>
<head>
    <title>Books</title>
    <#include "../partials/head.ftlh">
</head>
<body>

<#include "../partials/navbar.ftlh">

<div class="container-fluid">
    <div class="row">
        <#include "../partials/sidebar.ftlh">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h3 class="mb-3">Books</h3>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>#ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Publication Date</th>
                        <th class="text-center">Edit</th>
                        <th class="text-center">Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if books??>
                        <#list books as book>
                            <tr data-id="${book.id}">
                                <td><a href="/books/${book.id}/edit">#${book.id}</a></td>
                                <td>${book.title}</td>
                                <td>${book.author}</td>
                                <td>${book.publicationDate}</td>
                                <td class="text-center"><a class="btn btn-link" href="/books/${book.id}/edit"><span
                                                data-feather="edit"></span></a></td>
                                <td class="text-center">

                                    <button
                                            class="btn btn-link"
                                            data-toggle="modal"
                                            data-target="#modal"
                                            data-id="${book.id}"
                                    >
                                        <span data-feather="trash"></span>
                                    </button>

                                </td>
                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>

                <div id="modal" class="modal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Book</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p>Are you sure?</p>
                            </div>
                            <div class="modal-footer">
                                <form method="post" id="deleteForm">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </main>
    </div>
</div>

<#include "../partials/scripts.ftlh">
</body>
</html>
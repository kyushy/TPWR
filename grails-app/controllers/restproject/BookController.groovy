package restproject

import grails.converters.JSON
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

@Api(value = "/api/v1", tags = ["Book"], description = "Book Api's")
class BookController {

    static namespace = 'v1'

    @ApiOperation(
            value = "Retourne un Book en fonction de l'id",
            nickname = "book/{id}",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "GET",
            response = Book.class
    )
    @ApiResponses([
            @ApiResponse(code = 405,
                    message = "Method Not Allowed. Only GET is allowed"),

            @ApiResponse(code = 404,
                    message = "Method Not Found")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Book Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def getBook() {
        def b = Book.get(params.id)
        if(b != null)
            render b as JSON
        else
            render (status: 404)
    }

    @ApiOperation(
            value = "Retourne la liste des Book",
            nickname = "books/",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "GET",
            response = Book.class, responseContainer="List"
    )
    @ApiResponses([
            @ApiResponse(code = 405,
                    message = "Method Not Allowed. Only GET is allowed"),

            @ApiResponse(code = 404,
                    message = "Method Not Found")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
            @ApiImplicitParam(name = "Accept",
                    paramType = "header",
                    required = true,
                    defaultValue = "text/plain",
                    value = "Accept",
                    dataType = "string"),
    ])
    def getBooks() {
        def b = Book.all
        render b as JSON
    }

    @ApiOperation(
            value = "Retourne une Library en fonction de l'id du Book",
            nickname = "book/{id}/library",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "GET",
            response = Library.class
    )
    @ApiResponses([
            @ApiResponse(code = 405,
                    message = "Method Not Allowed. Only GET is allowed"),

            @ApiResponse(code = 404,
                    message = "Method Not Found")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Book Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def getLibrary() {
        def b = Book.get(params.id)
        if(b != null) {
            def lib = b.getLibrary()
            render lib as JSON
        }
        else
            render (status: 404)
    }


    @ApiOperation(
            value = "Mettre à jour un Book en fonction de l'id",
            nickname = "book/{id}",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "PUT",
            response = Book.class
    )
    @ApiResponses([
            @ApiResponse(code = 400,
                    message = "Bad Request"),

            @ApiResponse(code = 404,
                    message = "Method Not Found")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Book Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "name",
                    paramType = "query",
                    required = false,
                    value = "Book name",
                    dataType = "string"),

            @ApiImplicitParam(name = "isbn",
                    paramType = "query",
                    required = false,
                    value = "Book isbn",
                    dataType = "string"),

            @ApiImplicitParam(name = "author",
                    paramType = "query",
                    required = false,
                    value = "Book author",
                    dataType = "string"),

            @ApiImplicitParam(name = "library",
                    paramType = "query",
                    required = false,
                    value = "Library Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def updateBook(Book book) {
        if(book.save(flush: true))
            render (status: 200)
        else
            render (status: 400)
    }

    @ApiOperation(
            value = "Supprimer un Book en fonction de l'id",
            nickname = "book/{id}",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "DELETE",
            response = Book.class
    )
    @ApiResponses([
            @ApiResponse(code = 404,
                    message = "Method Not Found")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "id",
                    paramType = "path",
                    required = true,
                    value = "Book Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def deleteBook() {
        def b = Book.get(params.id)
        b.library.removeFromBooks(book)
        b.delete(flush: true)
        render (status: 200)
    }

    @ApiOperation(
            value = "Créer un Book",
            nickname = "book/",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = Book.class
    )
    @ApiResponses([
            @ApiResponse(code = 201,
                    message = "Created"),

            @ApiResponse(code = 400,
                    message = "Bad Request"),

            @ApiResponse(code = 404,
                    message = "Method Not Found")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "name",
                    paramType = "query",
                    required = true,
                    value = "Book name",
                    dataType = "string"),

            @ApiImplicitParam(name = "releaseDate",
                    paramType = "query",
                    required = true,
                    value = "Book release date",
                    dataType = "Date"),

            @ApiImplicitParam(name = "isbn",
                    paramType = "query",
                    required = true,
                    value = "Book isbn",
                    dataType = "string"),

            @ApiImplicitParam(name = "author",
                    paramType = "query",
                    required = true,
                    value = "Book author",
                    dataType = "string"),

            @ApiImplicitParam(name = "library",
                    paramType = "query",
                    required = true,
                    value = "Library Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def createBook(Book book) {
        Library lib = Library.get(params.library)
        if(lib.addToBooks(book).save(flush: true))
            render (status: 201)
        else
            render (status: 400)
    }

}

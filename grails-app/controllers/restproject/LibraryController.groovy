package restproject

import grails.converters.JSON
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

@Api(value = "/api/v1", tags = ["Library"], description = "Library Api's")
class LibraryController {

    static namespace = "v1"

    @ApiOperation(
            value = "Retourne une Library en fonction de l'id",
            nickname = "library/{id}",
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
                    value = "Library Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def getLibrary() {
        def lib = Library.get(params.id)
        if(lib != null)
            render lib as JSON
        else
            render (status: 404)
    }

    @ApiOperation(
            value = "Retourne la liste des Libraries",
            nickname = "libraries/",
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
            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def getLibraries() {
        def lib = Library.all
        render lib as JSON
    }

    @ApiOperation(
            value = "Retourne la liste des Book présent dans une Library en fonction de l'id",
            nickname = "library/{id}/books",
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
            @ApiImplicitParam(name = "id",
                    paramType = "path",
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
    def getBooks() {
        def lib = Library.get(params.id)
        if(lib != null)
            render lib.getBooks() as JSON
        else
            render (status: 404)
    }

    @ApiOperation(
            value = "Créer une Library",
            nickname = "library/",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = Library.class
    )
    @ApiResponses([
            @ApiResponse(code = 405,
                    message = "Method Not Allowed. Only GET is allowed"),

            @ApiResponse(code = 404,
                    message = "Method Not Found")
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = "name",
                    paramType = "path",
                    required = true,
                    value = "Library name",
                    dataType = "string"),

            @ApiImplicitParam(name = "address",
                    paramType = "path",
                    required = true,
                    value = "Library address",
                    dataType = "string"),

            @ApiImplicitParam(name = "year created",
                    paramType = "path",
                    required = true,
                    value = "Library creation year",
                    dataType = "Integer"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def createLibrary(Library library) {
        if(library.save(flush: true))
            render (status: 201)
        else
            render (status: 401)
    }

    @ApiOperation(
            value = "Mettre à jour une library en fonction de l'id",
            nickname = "library/{id}",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "PUT",
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
                    value = "Library Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "name",
                    paramType = "query",
                    required = false,
                    value = "Library name",
                    dataType = "string"),

            @ApiImplicitParam(name = "address",
                    paramType = "query",
                    required = false,
                    value = "Library address",
                    dataType = "string"),

            @ApiImplicitParam(name = "year created",
                    paramType = "query",
                    required = false,
                    value = "Library creation year",
                    dataType = "Integer"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def updateLibrary(Library library) {
        if(library.save(flush: true))
            render (status: 200)
        else
            render (status: 401)
    }

    @ApiOperation(
            value = "Supprimer une library en fonction de l'id",
            nickname = "library/{id}",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "DELETE",
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
                    value = "Library Id",
                    dataType = "string"),

            @ApiImplicitParam(name = "applicationType",
                    paramType = "header",
                    required = true,
                    defaultValue = "web",
                    value = "Application Types",
                    dataType = "string"),
    ])
    def deleteLibrary(Library library) {
        library.delete(flush: true)
        render (status: 200)
    }
}

package restproject

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/apiDoc/$action?/$id?"(controller: "apiDoc", action: "getDocuments")

        "/api/v1/book/$id"(controller: "book", action: "getBook", method: "GET")
        "/api/v1/books/"(controller: "book", action: "getBooks", method: "GET")
        "/api/v1/book/$id/library"(controller: "book", action: "getLibrary", method: "GET")
        "/api/v1/book/"(controller: "book", action: "createBook", method: "POST")
        "/api/v1/book/$id"(controller: "book", action: "updateBook", method: "PUT")
        "/api/v1/book/$id"(controller: "book", action: "deleteBook", method: "DELETE")

        "/api/v1/library/$id"(controller: "library", action: "getLibrary", method: "GET")
        "/api/v1/library/$id/books"(controller: "library", action: "getBooks", method: "GET")
        "/api/v1/libraries/"(controller: "library", action: "getLibraries", method: "GET")
        "/api/v1/library/"(controller: "library", action: "createLibrary", method: "POST")
        "/api/v1/library/$id"(controller: "library", action: "updateLibrary", method: "PUT")
        "/api/v1/library/$id"(controller: "library", action: "deleteLibrary", method: "DELETE")
    }
}

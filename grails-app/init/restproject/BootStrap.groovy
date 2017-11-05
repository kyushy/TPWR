package restproject

class BootStrap {

    def init = { servletContext ->


        Library library = new Library(name: "lib", address: "360 mico", yearCreated: 1987)
        Library library2 = new Library(name: "lib2", address: "405 soph", yearCreated: 2006)

        Book book = new Book(name: "livre", releaseDate: new Date(), isbn: "123456", author: "moi")
        Book book2 = new Book(name: "bouquin", releaseDate: new Date(), isbn: "789456", author: "moi")
        Book book3 = new Book(name: "coco", releaseDate: new Date(), isbn: "1793468", author: "moi")

        library.addToBooks(book).save flush: true
        library.addToBooks(book3).save flush: true
        library2.addToBooks(book2).save flush: true
    }

    def destroy = {
    }
}

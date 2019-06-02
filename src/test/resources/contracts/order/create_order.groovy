package order

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method POST()
        url '/orders'
        headers {
            contentType('application/json')
        }
        body(
                address:
                        $(
                                name: $(
                                        firstName: "Boss",
                                        middleName: "I would say",
                                        lastName: "DJ",
                                ),
                                firstLine: "20B",
                                secondLine: "Frummpy village",
                                city: "London Town",
                                county: "Greater London",
                                postCode: "SW21 2JK",
                        ),
                telephoneNumber: "07912302938",
                email: "brah.stickum@reel.com",
                notes: $("I think I'll have myself a beer"),
                quantity: 1,
                totalPrice: 0.99,
                paymentStatus: $(
                        paymentMethod: "ONLINE",
                        paid: true
                )
        )
    }
    response {
        status CREATED()
        headers {
            contentType('application/json')
            header(location(), anyUrl())
        }
        body(
                createdEntity: $(
                        id: anyNonBlankString()
                )
        )
    }
}
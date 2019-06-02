package order

import org.springframework.cloud.contract.spec.Contract
[
Contract.make {
    request {
        method GET()
        url '/orders/12345'
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body(
                id: "12345",
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
                                country: "United Kingdom",
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
        headers {
            contentType('application/json')
        }
    }

}]
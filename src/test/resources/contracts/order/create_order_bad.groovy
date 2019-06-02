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
                                secondLine: "Frummpy village",
                                city: "London Town",
                                county: "Greater London",
                                postCode: "SW21 2JK",
                        ),
                paymentStatus: $(
                        paymentMethod: "ONLINE",
                        paid: true
                )
        )
    }
    response {
        status BAD_REQUEST()
        headers {
            contentType('application/json')

        }
        body(
                error: $(
                        code: anyNonBlankString(),
                        message: anyNonBlankString(),
                        target: optional(anyNonBlankString()),
                                details:optional(anyNonBlankString()),
                        innererror: optional($(
                                code: anyNonBlankString(),
                                innererror: any()
                        )),
                )
        )
    }
}
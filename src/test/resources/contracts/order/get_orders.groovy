package order

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url '/orders'
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body(
                orders:[any()]
        )
    }
}
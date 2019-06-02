package order

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url '/orders/12346'
        headers {
            contentType('application/json')
        }
    }
    response {
        status NOT_FOUND()
    }
}
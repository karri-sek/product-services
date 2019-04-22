This code repo contains the code base for test.

### Description:
 This code bases contains the business logic to pull the products details from an api 
And present to the caller in desired format.

This project is developed as a spring boot maven Rest service. Exposed a *REST* GET endpoint ` http://localhost:8080/products?labelType=ShowWasThenNow `

#### Steps to execute:

    1: Run command `mvn clean install` from the project root folder.
Above command should be successful and run all the *tests*, you should be able to see a message *BUILD SUCCESS*

### Run the application and hit the GET endpoint through postman

    1: Install maven in your local machine.
    2: Run this command from the project root folder ` mvn spring-boot:run`
    3: Hit this endpoint `http://localhost:8080/products?labelType=ShowWasThenNow from post man.
Note: query param is optional
The below results are ordered based on the reduction rate (was-now)

    Response:
    {
    "products": [
        {
            "productId": "3421340",
            "title": "Phase Eight Beatrix Floral Printed Dress, Cream/Red",
            "colorSwatches": [],
            "nowPrice": "£99",
            "priceLabel": "Was £140, now £99"
        },
        {
            "productId": "3428696",
            "title": "Hobbs Kiona Dress, Green",
            "colorSwatches": [],
            "nowPrice": "£74",
            "priceLabel": "Was £149, then £89, now £74"
        },
        {
            "productId": "3391561",
            "title": "Phase Eight Katlyn Three Quarter Sleeve Spot Dress, Navy/Ivory",
            "colorSwatches": [],
            "nowPrice": "£59",
            "priceLabel": "Was £99, then £63, now £59"
        },
        {
            "productId": "3467432",
            "title": "Boden Rosamund Posy Stripe Dress",
            "colorSwatches": [
                {
                    "color": "Navy",
                    "rgbColor": null,
                    "skuId": "237334043"
                },
                {
                    "color": "Mimosa Yellow",
                    "rgbColor": null,
                    "skuId": "237334029"
                }
            ],
            "nowPrice": "£63",
            "priceLabel": "Was £90, now £63"
        },
        {
            "productId": "3459039",
            "title": "Hobbs Bayview Dress, Blue/Multi",
            "colorSwatches": [],
            "nowPrice": "£55",
            "priceLabel": "Was £89, now £55"
        }
    ]
}

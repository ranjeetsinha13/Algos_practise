import java.io.IOException

class CartImpl {

    companion object {
        val cart: Cart = Cart(
            mutableSetOf(),
            mutableMapOf<String, Int>() as HashMap<String, Int>, 0.0f
        )
    }


    fun addItemsToCart(listofProduct: List<Product>) {

        for (p in listofProduct) {
            cart.ProductList.add(p)
            incrementItemCount(p)
        }

    }


    fun removeItemsFromCart(listofProduct: List<Product>) {

        for (p in listofProduct) {
            cart.ProductList.remove(p)
            cart.productCount.remove(p.productId)
        }

    }

    @Throws(IOException::class)
    fun incrementItemCount(item: Product) {

        //todo handle max allowed quantity
        if (cart.ProductList.contains(item)) {
            cart.productCount[item.productId]?.plus(1)?.let { cart.productCount.put(item.productId, it) }
        } else {
            throw IOException("Item is not added to the cart")
        }
    }

    @Throws(IOException::class)
    fun decrementItemCount(item: Product) {

        if (cart.ProductList.contains(item)) {
            cart.productCount[item.productId]?.minus(1)?.let { cart.productCount.put(item.productId, it) }

        } else {
            throw IOException("Item is not added to the cart")
        }

    }


    fun getCart(): Cart {
        return cart
    }


    data class Product(
        val productId: String,
        val productPrice: Float,
        val offerId: String,
        val maxAllowedQuantity: Int,
        val imageUrl: String,
        val name: String,
        val description: String,
        val isOutOfStock: Boolean,
        val offerApplied: Boolean,
        val offerPrice: Float
    )

    data class Cart(
        val ProductList: MutableSet<Product>,
        val productCount: HashMap<String, Int>,
        val totalPrice: Float,
        val offerId: String? = null
    )


}

fun main() {

    val c = CartImpl()
    c.incrementItemCount(
        CartImpl.Product(
            "111", 33.0f, "3",
            4, "sfd", "sf", "32423", false, false, 33.0f
        )
    )

    println(c.getCart().ProductList.size)
}
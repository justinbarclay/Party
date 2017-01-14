class ProductsController < ApplicationController
    def index
        products = Product.all.map { |product| {id: product.id, name: product.name} }
        render(json: products.to_json)
    end

    def show
        product = Product.find(params[:id])
        render(json: product.to_json())
    end

    def create
        success = Product.create(create_params)
        render(json: success.to_json)
    end

private
    def create_params
        params.require(:product).permit(:name, :location, :count)
    end
end

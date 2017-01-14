class Product < ApplicationRecord
    def shout
        name.upcase
    end
end

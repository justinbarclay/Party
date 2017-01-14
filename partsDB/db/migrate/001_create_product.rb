class CreateProduct < ActiveRecord::Migration
    def change
        create_table :products do |t|
            t.text :name, null: false
            t.text :location, null: false
            t.integer :count, null: false

            t.index :name, unique: true
            t.timestamps
        end
    end
end


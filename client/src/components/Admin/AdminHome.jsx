import React from 'react'
import MenuForm from './MenuForm'
import MenuList from './MenuList'

export const AdminHome = () => {
    return (
        <div>
            <div className='flex justify-center mt-10 mb-10'>
                <h1 className='font-bold text-4xl '>Menu Update</h1>
            </div>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-2">
                <div className='p-5'>
                    <div className='flex md:m-5 justify-center '>
                        <MenuForm/>
                    </div>
                </div>
                <div className='p-3'>
                    <div className='flex justify-center'>
                        <MenuList/>
                    </div>
                </div>
            </div>
        </div>
    )
}
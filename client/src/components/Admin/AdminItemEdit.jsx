import React from 'react'
import MenuForm from './MenuForm'
import AdminEditForm from './AdminEditForm'

function AdminItemEdit() {
    return (
        <div className='flex justify-center'>
            <div className='md:w-3/2'>
                <AdminEditForm />
            </div>
        </div>
    )
}

export default AdminItemEdit
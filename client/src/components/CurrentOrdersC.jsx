import React from 'react'

const CurrentOrdersC = () => {
    return (
        <div className='flex justify-center'>
            <div className='grid md:grid-cols-2 rounded-lg bg-white shadow-lg w-full m-5 p-2 md:w-2/3 md:m-5 md:p-5'>
                <div>
                    <p className='font-semibold'>OrderId:#1234222</p>
                    <ol className="mt-3 list-decimal">
                        <div className="flex space-x-4">
                            <div className='font-medium'>
                                <ul>
                                    <li>Coffee:</li>
                                    <li>Tea:</li>
                                    <li>Milk:</li>
                                </ul>
                            </div>
                            <div>
                                <ul>
                                    <li>2</li>
                                    <li>1</li>
                                    <li>3</li>
                                </ul>
                            </div>
                        </div>

                    </ol>
                    <div className='mt-5'>
                        <div className='mr-5 md:mr-10 mt-1'>
                            <span className='font-semibold'>Total Amount:</span><span className='ml-2'>$10</span>
                        </div>
                    </div>
                </div>
                <div className='flex flex-col md:mt-0 mt-6'>
                    <p className='font-semibold'>Status:</p>
                    <form className='mt-2' action="">
                        <input className='m-1' type="radio" id='placed' name='orderStatus' defaultChecked />
                        <label htmlFor="placed">Placed</label>

                        <input className='m-1' type="radio" id='preparing' name='orderStatus' />
                        <label htmlFor="preparing">Preparing</label>

                        <input className='m-1' type="radio" id='ready' name='orderStatus' />
                        <label htmlFor="ready">Ready</label>
                    </form>
                    <div className='mt-3'>
                        <button className='bg-primary text-white p-2 border rounded-lg font-medium'>Done</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default CurrentOrdersC
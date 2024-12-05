'use client';

import React, {useState} from 'react';
import {Button, DatePicker, Form, Input} from 'antd';
import moment, {Moment} from 'moment';
import Table from './Table';
import InputMask from 'react-input-mask';

interface Pessoa {
    nome?: string;
    cpf?: string;
    nascimento?: Moment;
    cep?: string;
    rua?: string;
    numero?: string;
    cidade?: string;
    estado?: string;
}

const handleFormSubmit = (values: Pessoa): void => {
    console.log('Success:', values);
};

const handleFormSubmitFailed = (errorInfo: any): void => {
    console.log('Failed:', errorInfo);
};


export default function Page() {
    const [pessoa, setPessoa] = useState<Pessoa>({});
    const [cepIsNotEmpty, setCepIsNotEmpty] = useState<boolean>(false);

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>): void => {
        setCepIsNotEmpty(!!event.target.value);
        setPessoa({...pessoa, cep: event.target.value});
    }


    return (
        <>
            <h1 className="text-2xl font-bold">Cadastrar Pessoas</h1>

            <div className="border border-gray-300 shadow-md p-4 min-h-[70vh]">
                <Form
                    name="loginForm"
                    labelCol={{span: 8}}
                    wrapperCol={{span: 16}}
                    style={{maxWidth: 1200}}
                    initialValues={{}}
                    onFinish={handleFormSubmit}
                    onFinishFailed={handleFormSubmitFailed}
                    autoComplete="off"
                >
                    <fieldset>
                        <legend>Pessoa</legend>
                    </fieldset>
                    <Form.Item
                        label="Nome"
                        name="nome"
                        rules={[{required: true, message: 'Nome é obrigatório!'}]}
                    >
                        <Input/>
                    </Form.Item>

                    <Form.Item
                        label="CPF"
                        name="cpf"
                        rules={[{required: true, message: 'CPF é obrigatório!'}]}
                    >
                        <InputMask mask="999.999.999-99">
                            {(inputProps: any) => <Input {...inputProps}/>}
                        </InputMask>
                    </Form.Item>
                    <Form.Item
                        label="Data Nascimento"
                        name="nascimento"
                        rules={[
                            {
                                required: false,
                                message: 'Data de nascimento é obrigatória!',
                            },
                            {
                                validator: (rule, value: Moment) => {
                                    if (value && value.isAfter(moment())) {
                                        return Promise.reject('A data de nascimento não pode ser maior que a data atual!');
                                    }
                                    return Promise.resolve();
                                },
                            },
                        ]}
                    >
                        <DatePicker/>
                    </Form.Item>

                    <fieldset>
                        <legend>Endereço</legend>
                        <Form.Item
                            label="CEP"
                            name="cep"
                            rules={[{required: cepIsNotEmpty, message: 'O CEP é obrigatório!'}]}
                        >
                            <Input.Search onChange={handleInputChange}/>
                        </Form.Item>
                        <Form.Item
                            label="Rua"
                            name="rua"
                            rules={[{required: cepIsNotEmpty, message: 'A rua é obrigatória!'}]}
                        >
                            <Input/>
                        </Form.Item>
                        <Form.Item
                            label="Numero"
                            name="numero"
                            rules={[{required: cepIsNotEmpty, message: 'O número é obrigatório!'}]}
                        >
                            <Input/>
                        </Form.Item>
                        <Form.Item
                            label="Cidade"
                            name="cidade"
                            rules={[{required: true, message: 'Please input your username!'}]}
                        >
                            <Input/>
                        </Form.Item>
                        <Form.Item
                            label="Estado"
                            name="estado"
                            rules={[{required: true, message: 'Please input your username!'}]}
                        >
                            <Input/>
                        </Form.Item>
                    </fieldset>
                    <Form.Item label={null}>
                        <Button type="primary" htmlType="submit">
                            Salvar
                        </Button>
                    </Form.Item>
                </Form>
                <Table/>
            </div>
        </>
    );
}